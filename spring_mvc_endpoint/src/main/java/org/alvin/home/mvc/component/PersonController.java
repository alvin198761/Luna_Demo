package org.alvin.home.mvc.component;

import org.alvin.home.mvc.Person;
import org.alvin.home.mvc.component.IPersonService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.*;
import org.springframework.boot.actuate.endpoint.mvc.MetricsMvcEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Method;

@Controller
@RequestMapping("/data")
public class PersonController implements InitializingBean {

    public PersonController() {
        System.out.println("-------");
    }

    @Autowired
    private IPersonService personService;

    @RequestMapping(value = "/person", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Person getPersonDetail(@RequestParam(value = "id", required = false,
            defaultValue = "0") Integer id) {
        Person p = personService.getPersonDetail(id);
        return p;
    }


    private ObjectMapper mapper = new ObjectMapper();


    @Autowired
    private MetricsEndpoint metrics;
    @Autowired
    private HealthEndpoint health;
    @Autowired
    private EnvironmentEndpoint environment;
    @Autowired
    private BeansEndpoint beans;
    @Autowired
    private InfoEndpoint info;
    @Autowired
    private ConfigurationPropertiesReportEndpoint config;
    @Autowired
    private RequestMappingEndpoint request;
    @Autowired
    private TraceEndpoint trace;
    @Autowired
    private DumpEndpoint dump;


    @RequestMapping(value = "/metrics", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getDump() throws JsonProcessingException {
        return mapper.writeValueAsString(metrics.invoke());
    }

    @RequestMapping(value = "/health", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getEnvironment() throws JsonProcessingException {
        return mapper.writeValueAsString(health.invoke());
    }

    @RequestMapping(value = "/environment", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String environment() throws JsonProcessingException {
        return mapper.writeValueAsString(environment.invoke());
    }

    @RequestMapping(value = "/beans", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String beans() throws JsonProcessingException {
        return mapper.writeValueAsString(beans.invoke());
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String info() throws JsonProcessingException {
        return mapper.writeValueAsString(info.invoke());
    }

    @RequestMapping(value = "/config", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String config() throws JsonProcessingException {
        return mapper.writeValueAsString(config.invoke());
    }

    @RequestMapping(value = "/request", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String request() throws JsonProcessingException {
        return mapper.writeValueAsString(request.invoke());
    }

    @RequestMapping(value = "/trace", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String trace() throws JsonProcessingException {
        return mapper.writeValueAsString(trace.invoke());
    }

    @RequestMapping(value = "/dump", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String dump() throws JsonProcessingException {
        return mapper.writeValueAsString(dump.invoke());
    }

    public void afterPropertiesSet() throws Exception {
        Method [] methods =  metrics.getClass().getDeclaredMethods();
        System.out.println(methods);
        metrics.registerPublicMetrics(new SystemPublicMetrics());
        metrics.registerPublicMetrics(new TomcatPublicMetrics());
    }
}