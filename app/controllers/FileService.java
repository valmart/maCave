package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import java.io.File;

/**
 * Created by val on 24/09/15.
 */
public class FileService extends Controller {
    static String path = "/public/images/qr/";
    public static Result getQRCodes(String file){
        File myfile = new File(System.getenv("PWD")+path+file);
        return ok(myfile);
    }
}
