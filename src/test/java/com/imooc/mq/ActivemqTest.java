package com.imooc.mq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.*;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivemqTest {

    /**
     * queue的发送代码如下
     * @throws JMSException
     */
    @Test
    public  void testMQProducerQueue() throws JMSException {
        //1、创建连接工厂对象，需要制定ip和端口号
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://39.96.82.151:61616");
        //2、使用连接工厂创建一个连接对象
        Connection connection = connectionFactory.createConnection();
        //3、开启连接
        connection.start();
        //4、使用连接对象创建会话（session）对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5、使用会话对象创建目标对象，包含queue和topic（一对一和一对多）
        Queue queue = session.createQueue("test-queue");
        //6、使用会话对象创建生产者对象
        MessageProducer producer =  session.createProducer(queue);
        //7、使用会话对象创建一个消息对象
        TextMessage  textMessage = session.createTextMessage("hello!test-queue");
        //8、发送消息
        producer.send(textMessage);
        //9、关闭资源
        producer.close();        session.close();
        connection.close();
    }

    @Test
    public void TestMQConsumerQueue() throws JMSException, IOException {
        //1、创建连接工厂对象，需要制定ip和端口号
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://39.96.82.151:61616");
        //2、使用连接工厂创建一个连接对象
        Connection  connection = connectionFactory.createConnection();
        //3、开启连接
        connection.start();
        //4、使用连接对象创建（session）对象
        Session  session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5、使用会话对象创建目标对象，包含queue 和topic(一对一和一对多)
        Queue queue =  session.createQueue("test-queue");
        //6、使用会话对象创建消费者对象
        MessageConsumer consumer = session.createConsumer(queue);
        //7、向consumer对象中设置一个messageListener对象，用来接收消息
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if(message instanceof  TextMessage){
                    TextMessage textMessage = (TextMessage)message;
                    try {
                        System.out.println(textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        //8、程序等待接收用户消息
        System.in.read();
        //9、关闭资源
        consumer.close();
        session.close();
        connection.close();
    }
}
