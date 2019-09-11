 import java.util.Hashtable;

import javax.naming.AuthenticationException;
import javax.naming.AuthenticationNotSupportedException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
 

public class LdapTest {
	public static void main(String[] args) {
		String url = "ldap://ldap.reed.edu:389";
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, url);
		//env.put(Context.SECURITY_AUTHENTICATION, "wsbind");
		env.put(Context.SECURITY_PRINCIPAL, "ou=people,dc=reed,dc=edu");
		//env.put(Context.SECURITY_CREDENTIALS, "wps4nasco");
		 
		try {
		    DirContext ctx = new InitialDirContext(env);
		    System.out.println("connected");
		    System.out.println(ctx.getEnvironment());
		     
		    // do something useful with the context...
		 
		    ctx.close();
		 
		} catch (AuthenticationNotSupportedException ex) {
		    System.out.println("The authentication is not supported by the server");
		} catch (AuthenticationException ex) {
		    System.out.println("incorrect password or username");
		} catch (NamingException ex) {
		    System.out.println("error when trying to create the context");
		}
	}

}
