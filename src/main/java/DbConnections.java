import java.sql.*;

public class DbConnections {
    public DbConnections() {

    }

    public void nativeSQL() {

        try {
            Class.forName("com.mysql.jdbc.driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/database",
                    "myLogin",
                    "myPassword");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Statement stmt = conn.createStatement();
            try {
                ResultSet rs = stmt.executeQuery("SELECT * FROM Table WHERE color = 'blue'");
                try {
                    while (rs.next()) {
                        int numColumns = rs.getMetaData().getColumnCount();
                        for (int i = 1; i <= numColumns; i++) {
                            // Column numbers start at 1.
                            // Also there are many methods on the result set to return
                            //  the column as a particular type. Refer to the Sun documentation
                            //  for the list of valid conversions.
                            System.out.println("COLUMN " + i + " = " + rs.getObject(i));
                        }
                    }
                } finally {
                    try {
                        rs.close();
                    } catch (Throwable ignore) { /* Propagate the original exception
instead of this one that you may want just logged */
                    }
                }
            } finally {
                try {
                    stmt.close();
                } catch (Throwable ignore) { /* Propagate the original exception
instead of this one that you may want just logged */
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //It's important to close the connection when you are done with it
            try {
                conn.close();
            } catch (Throwable ignore) { /* Propagate the original exception
instead of this one that you may want just logged */
            }
        }
    }

}
