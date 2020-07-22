package com.example.demo.controller;

import com.example.demo.dao.ContextRepository;
import com.example.demo.dao.QasRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.model.Context;
import com.example.demo.model.Qas;
import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private UserRepository userRepository;

    @Resource
    private ContextRepository contextRepository;

    @Resource
    private QasRepository qasRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String create() {
        Date data = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(data);

        userRepository.save(new User("aa", "aa123456", "aa@126.com", "aa", formattedDate));
        userRepository.save(new User("bb", "bb123456", "bb@126.com", "bb", formattedDate));
        userRepository.save(new User("cc", "cc123456", "cc@126.com", "cc", formattedDate));

        return "create 3";
    }

    @RequestMapping(value = "/query/{name}", method = RequestMethod.GET)
    public String get(@PathVariable("name") String name) {
        User user = userRepository.findByUserName(name);
        return user.toString();
    }


    @RequestMapping(value = "/addContext", method = RequestMethod.POST)
    public int addContext(@RequestParam("id") int id, @RequestParam("context_text") String context_text) {
        Context context = new Context();
        System.out.println(id+":"+context_text);
        context.setId(id);
        context.setContext_text(context_text);

        contextRepository.save(context);

        return id;
    }

    @RequestMapping(value = "/addQas", method = RequestMethod.POST)
    public String addQas(@RequestParam("id") int id, @RequestParam("question") String question, @RequestParam("answer_text") String answer_text,
                      @RequestParam("answer_start") int answer_start, @RequestParam("context_id") int context_id) {
        Qas qas = new Qas();
        qas.setId(id);
        qas.setQuestion(question);
        qas.setAnswer(answer_text);
        qas.setStart(answer_start);
        qas.setContext(contextRepository.findById(context_id).get());

        qasRepository.save(qas);

        return qas.toString();

    }

}
