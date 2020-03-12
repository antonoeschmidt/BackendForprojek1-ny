package rest;

import brugerautorisation.data.Bruger;
import brugerautorisation.transport.rmi.Brugeradmin;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class TestRest {

    public static Javalin app;


    public static void main(String[] args) throws Exception {
        start();
    }

    public static void stop() {
        app.stop();
        app = null;
    }

    public static void start() throws Exception {
        if (app!=null) return;

        app = Javalin.create().start(8080);
        app.before(ctx -> {
            System.out.println("Javalin Server fik "+ctx.method()+" på " +ctx.url()+ " med query "+ctx.queryParamMap()+ " og form " +ctx.formParamMap());
        });
        app.exception(Exception.class, (e, ctx) -> {
            e.printStackTrace();
        });
        //app.config.addStaticFiles("webside");
        app.get("", ctx -> ctx.result("heeey"));
        // Serverside gemererede websider
        app.get("/hey", ctx -> ctx.status(404).result("Ups, der kom en...!").contentType("text/html"));
        //app.get("/formular", ctx -> formular(ctx));

        // REST endpoints
        app.config.enableCorsForAllOrigins();
        app.get("/rest/hej", ctx -> ctx.result("Hejsa, godt at møde dig!"));
        app.get("/rest/hej/:fornavn", ctx -> ctx.result("Hej "+ctx.queryParam("fornavn")+", godt at møde dig!"));
        //app.get("/rest/bruger/:brugernavn", ctx -> bruger(ctx));
        //app.post("/rest/sendGlemtAdgangskodeEmail", ctx -> sendGlemtAdgangskodeEmail(ctx));
    }
}
