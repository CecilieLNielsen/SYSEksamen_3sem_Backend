//package rest;
//
//import entities.Airport;
//import entities.Country;
//import entities.Flight;
//import io.restassured.RestAssured;
//import static io.restassured.RestAssured.given;
//import io.restassured.parsing.Parser;
//import java.net.URI;
//import java.util.ArrayList;
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.ws.rs.core.UriBuilder;
//import org.glassfish.grizzly.http.server.HttpServer;
//import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
//import org.glassfish.jersey.server.ResourceConfig;
//import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.hasSize;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import static rest.LoginEndpointTest.startServer;
//import utils.EMF_Creator;
//
///**
// *
// * @author rh
// */
//public class FlightEndPointTest {
//
//    private static final int SERVER_PORT = 7777;
//    private static final String SERVER_URL = "http://localhost/api";
//
//    static final URI BASE_URI = UriBuilder.fromUri(SERVER_URL).port(SERVER_PORT).build();
//    private static HttpServer httpServer;
//    private static EntityManagerFactory emf;
//
//    static HttpServer startServer() {
//        ResourceConfig rc = ResourceConfig.forApplication(new ApplicationConfig());
//        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
//    }
//
//    @BeforeAll
//    public static void setUpClass() {
//        //This method must be called before you request the EntityManagerFactory
//        EMF_Creator.startREST_TestWithDB();
//        emf = EMF_Creator.createEntityManagerFactoryForTest();
//        EntityManager em = emf.createEntityManager();
//
//        httpServer = startServer();
//
//        //Setup RestAssured
//        RestAssured.baseURI = SERVER_URL;
//        RestAssured.port = SERVER_PORT;
//        RestAssured.defaultParser = Parser.JSON;
//
//    }
//
//    @AfterAll
//    public static void closeTestServer() {
//        //System.in.read();
//
//        //Don't forget this, if you called its counterpart in @BeforeAll
//        EMF_Creator.endREST_TestWithDB();
//        httpServer.shutdownNow();
//    }
//
//    @BeforeEach
//    public void setUp() {
//        EntityManager em = emf.createEntityManager();
//        try {
//            em.getTransaction().begin();
//
//            em.createQuery("delete from Flight").executeUpdate();
//            em.createQuery("delete from Airport").executeUpdate();
//            em.createQuery("delete from Country").executeUpdate();
//
//            List<Airport> airports = new ArrayList();
//            Flight flight = new Flight();
//            Airport airport = new Airport();
//            Airport airport2 = new Airport();
//            airport.setAirportName("Spain airport");
//            airport2.setAirportName("France airport");
//
//            airports.add(airport);
//            airports.add(airport2);
//            Country country = new Country("Spain", airports);
//            flight.setDestinationAirport(airport);
//            flight.setTakeoffAirport(airport2);
//            country.setAirports(airports);
//
//            airport.setCountry(country);
//
//            em.persist(country);
//            em.persist(flight);
//            em.getTransaction().commit();
//
//        } finally {
//            em.close();
//        }
//    }
//
//    //virker når man køre denne fil alene men ikke når man køre den i clean og build....
//    @Test
//    public void testServerIsUp() {
//        System.out.println("Testing is server UP");
//        given().when().get("/flight").then().statusCode(200);
//    }
//
//    @Test
//    public void testGetAll() {
//        given()
//                .contentType("application/json")
//                .when()
//                .get("/flight/")
//                .then()
//                .statusCode(200)
//                .body("flight", hasSize(1));
//
//    }
//
//}
