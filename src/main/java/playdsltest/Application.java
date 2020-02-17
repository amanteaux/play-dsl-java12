package playdsltest;

import play.Mode;
import play.mvc.Results;
import play.routing.RoutingDsl;
import play.server.Server;

public class Application {

	public static void main(String[] args) {
		Server
			.forRouter(
				Mode.DEV,
				8080,
				builtInComponents -> RoutingDsl
					.fromComponents(builtInComponents)
					.GET("/*to")
					.routingTo((request, to) -> {
						return Results.ok("Ok " + to);
					})
					.build()
			);
	}

}
