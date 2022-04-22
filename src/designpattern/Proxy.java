package designpattern;

interface DatabaseExecutor {
    void execute(String query);
}

class DatabaseExecutorImpl implements DatabaseExecutor {
    @Override
    public void execute(String query) {
        System.out.println("Run: " + query);
    }
}

class DatabaseExecutorProxy implements DatabaseExecutor {
    private boolean isAdmin;
    private DatabaseExecutor executor;

    public DatabaseExecutorProxy(String name, String password) {
        if (name == "Admin" && password == "password") {
            isAdmin = true;
        }
        executor = new DatabaseExecutorImpl();
    }


    @Override
    public void execute(String query) {
        if (isAdmin) {
            executor.execute(query);
        }
        else {
            System.out.println("Can't run.");
        }
    }
}

public class Proxy {
    public static void main(String[] args) {
        DatabaseExecutor admin = new DatabaseExecutorProxy("Admin", "password");
        admin.execute("Select * from Employees");
        DatabaseExecutor user = new DatabaseExecutorProxy("User", "123");
        user.execute("Select * from Employees");
    }
}
