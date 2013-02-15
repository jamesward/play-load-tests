package controllers;

import org.springframework.scheduling.annotation.Async;
import play.libs.Akka;
import play.libs.F;
import play.mvc.Controller;
import play.mvc.Result;

public class JavaApplication extends Controller {
    
    public static Result basic() {
        return ok("");
    }
    
    public static Result sleep(Long millis) {
        return async(
            F.Promise.<Result>timeout(ok(""), millis)
        );
    }
    
}
