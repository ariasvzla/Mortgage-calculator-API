package com.dominic.mortgage;

import com.google.gson.Gson;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;


@Path("/mortgage")
public class MortgageCalculator {
    
    @GET
    @Path("/payment")
    @Produces("application/json")
    public Response getPayment(@Context UriInfo  info){
        Gson gson = new Gson();
        
        String principle = info.getQueryParameters().getFirst("principle");
	String interest = info.getQueryParameters().getFirst("interest");
        String term = info.getQueryParameters().getFirst("term");
        
        
        MortgageInfo mortgageInfo = new MortgageInfo(Double.parseDouble(principle), Double.parseDouble(interest), Integer.parseInt(term));

       return Response.status(200).entity(gson.toJson(mortgageInfo.payment)).build();
       
       
    }
    
    @POST
    @Path("/echo")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(@FormParam("username") String username,   @FormParam("password") String password ) {
     Gson gson = new Gson();
Users use = new Users(username, password );

String newName=use.changeusername(username);

 return Response.status(200).entity(gson.toJson("Newname: " +(newName) + " Password: " + (password))).build();
    }

}
