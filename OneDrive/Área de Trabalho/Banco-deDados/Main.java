public class Main {
    public static void main(String[] args) {
        DatabaseManager dbManager = null;
        try {
            dbManager = new DatabaseManager("jdbc:sqlite:example.db");

            // Create
            Passageiro passageiro1 = new Passageiro("João Silva", "123456789");
            dbManager.createPassageiro(passageiro1);

            // Retrieve
            Passageiro retrievedPassageiro = dbManager.getPassageiro("123456789");
            System.out.println("Retrieved Passageiro: " + retrievedPassageiro);

            // Update
            passageiro1.setNome("João da Silva");
            dbManager.updatePassageiro(passageiro1);

            // Verify Update
            Passageiro updatedPassageiro = dbManager.getPassageiro("123456789");
            System.out.println("Updated Passageiro: " + updatedPassageiro);

            // Delete
            dbManager.deletePassageiro(passageiro1);

            // Verify Delete
            Passageiro deletedPassageiro = dbManager.getPassageiro("123456789");
            System.out.println("Deleted Passageiro: " + deletedPassageiro);

        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (dbManager != null) {
                dbManager.close();
            }
        }
    }
}
