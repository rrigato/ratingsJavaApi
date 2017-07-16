/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author ryan
 */
@Path("ratings")
public class Ratings {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Ratings
     */
    public Ratings() {
    }
    
    /*
        Gets a connection to the amazon web services for dynamoDb
        Using configuration parameters set in the context.xml
    */
    private AmazonS3 getConnection (String id, String key){
        
        //Loads access keys from environment variables
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(id, key);
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                        .build();
        
        return(s3Client);
    }

    /**
     * Retrieves representation of an instance of api.Ratings
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@Context ServletContext context) {
        
        //AmazonS3 s3Client = getConnection(context.getInitParameter("id").toString(), context.getInitParameter("key").toString());
        System.out.println(context.getInitParameter("key").toString());
        //System.out.println(s3Client);
        //TODO return proper representation object
        return("{\"Hello\":\"world\"}");
    }

    /**
     * PUT method for updating or creating an instance of Ratings
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
