package com.dreamidea;

import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import static com.dreamidea.GreetingDB.greet;


/**
 * @author stillChina
 */
@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET)
    List<Greeting> getList() {
        return Lists.newArrayList(greet.asMap().values());
    }

    @RequestMapping(method = RequestMethod.POST)
    List<String> addContent(@RequestBody final String content) {
        if (greet.asMap().values().stream().anyMatch(greeting -> greeting.getContent().equals(content))) {
            return Lists.newArrayList("添加失败, 内容'" + content + "'已存在");
        }
        Long id = counter.incrementAndGet();
        greet.put(String.valueOf(id), new Greeting(id, content));
        return Lists.newArrayList("添加成功: id=" + id);

    }
}
