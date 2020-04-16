package miu.group3.api.services;

import java.io.IOException;
import java.io.StringReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import miu.group3.api.documents.Product;

@Service
@Component
public class RabbitMQListner implements MessageListener {

	@Autowired
	private ProductService productService;

	public void onMessage(Message message) {
		String temp = new String(message.getBody());
		String temp2 = temp.substring(1, temp.length() - 1);
		String propertiesFormat = temp2.replaceAll(",", "\n");
		Properties properties = new Properties();

		try {
			properties.load(new StringReader(propertiesFormat));
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			HashMap<String, String> hashMap = new HashMap(properties);

			Hashtable<String, String> ht = new Hashtable<String, String>();
			for (Map.Entry me : hashMap.entrySet()) {
				ht.put(me.getKey().toString().replaceAll("^\"|\"$", ""), (String) me.getValue());
			}

			Product ob = new Product("XXX2", ht.get("title"), "summary", "desc", 10.0, 500.4, 14, true,
					"http://localhost:8080/productimages/3.jpg");
			System.out.println("Object " + ob);
		    productService.save(ob);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}