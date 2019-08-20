package application.rest.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Example {


    @RequestMapping("v1")
    public @ResponseBody ResponseEntity<String> example() {
        List<String> list = new ArrayList<>();
        //return a simple list of strings
        list.add("Congratulations, your application is up and running");
        return new ResponseEntity<String>(list.toString(), HttpStatus.OK);
    }

    @RequestMapping("/diagonal/{word}")
    public @ResponseBody ResponseEntity<String> diagonal(@PathVariable("word") String word)
    {
        List<String> list = new ArrayList<String>();
        char[] array = word.toCharArray();
        
        
        for(int i = 0; i < array.length; i++)
        {
            list.add("<div style = \"margin-left: 15px;\">");
            list.add(array[i]+"<br>");
            for(int j = 0; j < i; j++)
            {
                list.add(" ");
            }
        }
        list.add("</div>");
        return new ResponseEntity<String>(list.toString().replaceAll(","," ").replace("["," ").replace("]"," "), HttpStatus.OK);
    }

    


}
