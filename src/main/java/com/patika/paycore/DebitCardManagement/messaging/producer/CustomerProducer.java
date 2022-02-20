package com.patika.paycore.DebitCardManagement.messaging.producer;

import com.patika.paycore.DebitCardManagement.config.RabbitMQConfig;
import com.patika.paycore.DebitCardManagement.model.Customer;
import com.patika.paycore.DebitCardManagement.service.CustomerService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messaging/publish")
public class CustomerProducer {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private CustomerService customerService;

    @PostMapping("/{message}")
    public String publishMessage(@PathVariable String message){
        template.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY,message);
        return "Success";
    }

    @PostMapping("customer/{id}")
    public String publishCustomer(@PathVariable Integer id) {
        Customer customer = customerService.getCustomer(id);
        template.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, customer);
        return "Success";
    }

}
