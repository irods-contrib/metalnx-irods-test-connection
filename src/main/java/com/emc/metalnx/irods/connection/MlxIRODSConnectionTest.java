package com.emc.metalnx.irods.connection;

import org.irods.jargon.core.connection.AuthScheme;
import org.irods.jargon.core.connection.IRODSAccount;
import org.irods.jargon.core.exception.JargonException;
import org.irods.jargon.core.pub.IRODSAccessObjectFactory;
import org.irods.jargon.core.pub.IRODSFileSystem;

public class MlxIRODSConnectionTest {

    private static final Integer N_MANDATORY_ARGS = 6;

    public static void main(String[] args) throws JargonException {

        // Validating input
        if (args.length != N_MANDATORY_ARGS || !AuthScheme.getAuthSchemeList().contains(args[5])) {
            MlxIRODSConnectionTest.printUsage();
            System.exit(ExitStatus.ERROR.statusCode);
        }

        // Assigning input args to local variables (more readable)
        String irodsHost = args[0];
        Integer irodsPort = Integer.parseInt(args[1]);
        String irodsUser = args[2];
        String irodsPassword = args[3];
        String irodsZone = args[4];
        String irodsAuthScheme = args[5];

        try {
            // Creating iRODS account obj for authentication with input args and AO factory
            IRODSAccount acct = IRODSAccount.instance(irodsHost, irodsPort, irodsUser, irodsPassword, "", irodsZone, "");
            IRODSAccessObjectFactory factory = IRODSFileSystem.instance().getIRODSAccessObjectFactory();

            // Setting authentication scheme
            acct.setAuthenticationScheme(AuthScheme.findTypeByString(irodsAuthScheme));

            // Trying to authenticate
            factory.authenticateIRODSAccount(acct);

            // Closing session and client
            factory.closeSessionAndEatExceptions(acct);
        } catch (Exception e) {
            System.exit(ExitStatus.ERROR.statusCode);
        }

        System.exit(ExitStatus.SUCCESS.statusCode);
    }

    /**
     * Auxiliary method for usage instructions
     */
    private static void printUsage() {
        System.out.println("Tests iRODS connection for Metalnx setup.");
        System.out.println("Usage: java -jar test-connection.jar [irods-host] [irods-port] [irods-username] [irods-password] [irods-zone] [auth-scheme]");
        System.out.println("\t[auth-scheme] can be STANDARD, PAM, GSI or KERBEROS");
        System.out.println("");
        System.out.println("Example:");
        System.out.println("\tjava -jar test-connection.jar myIcat.example.com 1247 rods rods tempZone STANDARD");
        System.out.println("");
    }

    /**
     * Enumeration for exit status code.
     */
    private enum ExitStatus {
        SUCCESS(0), ERROR(1);
        private int statusCode;

        ExitStatus(int status) {
            this.statusCode = status;
        }
    }

}
