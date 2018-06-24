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
@RequestMapping("/sho/web")
@Slf4j
public class HomeController
{
    public static final String SHO_INDEX = "sho-index";
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
        if (!model.containsAttribute("scriptText")) {
            model.addAttribute("scriptText", DEFAULT_SCRIPT);
        }

        return SHO_INDEX;
    }

    @PostMapping("/execute")
    public RedirectView execute(
            @RequestParam(name = "scriptText", required = false) String scriptText,
            @RequestParam(name = "probe", required = false) String probe,
            RedirectAttributes redirectAttributes)
    {

        log.info("Probe = {}", probe);
        log.info("Received script: {}{}", System.lineSeparator(), scriptText);
        redirectAttributes.addFlashAttribute("scriptText", scriptText);

        Object result;
        try {
            result = scriptEngineHost.eval(scriptText);
        }
        catch (Exception e) {
            result = e;
        }
        
        redirectAttributes.addFlashAttribute("executionResult", result);
        return new RedirectView("/sho/web");
    }
}
