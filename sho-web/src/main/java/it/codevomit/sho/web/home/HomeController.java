package it.codevomit.sho.web.home;

import it.codevomit.sho.host.ScriptEngineHost;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author merka
 */
@Controller
@RequestMapping("/sho")
@Slf4j
public class HomeController
{
    public static final String DEFAULT_SCRIPT = "// Here you can do some cool stuff, like:\n"
            + "var service = applicationContext.getBean(\"dummyService\");\n"
            + "service.doSomeSideEffects();\n"
            + "var result = service.getRandomString();\n"
            + "result;";

    @Inject
    ScriptEngineHost scriptEngineHost;

    String currentScript;
    
    @GetMapping(value = {"", "/index", "/home"})
    public String index(
            Model model)
    {
        if(!model.containsAttribute("scriptText"))
            model.addAttribute("scriptText", DEFAULT_SCRIPT);

        return "index";
    }

    @PostMapping("/execute")
    public RedirectView execute(
            @RequestParam(name = "scriptText", required = false) String scriptText,
            @RequestParam(name = "probe", required = false) String probe,
            RedirectAttributes redirectAttributes)
    {

        log.info("Probe = {}", probe);
        log.info("Received script: {}{}", System.lineSeparator(), scriptText);

        Object result = scriptEngineHost.eval(scriptText);

        redirectAttributes.addFlashAttribute("executionResult", result);
        redirectAttributes.addFlashAttribute("scriptText", scriptText);

        return new RedirectView("/sho");
    }
}
