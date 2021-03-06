package ninoshunt.spring.freemarker.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * FreeMarkerのサンプル用コントローラ
 *
 * @author ninoshunt
 *
 */
@Controller
public class FreeMarkerSampleController {

    /**
     * TOPページ
     *
     * @return viewのパス
     */
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

}
