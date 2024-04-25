import com.example.national_bank_of_egypt.Models.Client;
import com.example.national_bank_of_egypt.Models.Model;
import com.example.national_bank_of_egypt.Models.Transactions;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    private Model model;

    @BeforeEach
    void setUp() {
        model = Model.getInstance();
    }

    @AfterEach
    void tearDown() {
        model = null;
    }

    @Nested
    @Order(1)
    class AdminTests {
        @Test
        void getViewFactory() {
            assertNotNull(model.getViewFactory());
        }

        @Test
        void getDataBaseDriver() {
            assertNotNull(model.getDataBaseDriver());
        }

        @Test
        void getAdminLoginSuccessFlag() {
            assertFalse(model.getAdminLoginSuccessFlag());
        }

        @Test
        void setAdminLoginSuccessFlag() {
            model.setAdminLoginSuccessFlag(true);
            assertTrue(model.getAdminLoginSuccessFlag());
        }

        @Test
        void evaluateAdminCred() {
            // Provide valid username and password for testing
            model.evaluateAdminCred("valid_username", "valid_password");
            assertTrue(model.getAdminLoginSuccessFlag());
        }
    }

    @Nested
    @Order(2)
    class ClientTests {
        @Test
        void getClientLoginSuccessFlag() {
            assertFalse(model.getClientLoginSuccessFlag());
        }

        @Test
        void setClientLoginSuccessFlag() {
            model.setClientLoginSuccessFlag(true);
            assertTrue(model.getClientLoginSuccessFlag());
        }

        @Test
        void getClient() {
            assertNotNull(model.getClient());
        }

        @Test
        void evaluateClientCred() {
            // Provide valid username and password for testing
            model.evaluateClientCred("@cClark3", "123456");
            assertTrue(model.getClientLoginSuccessFlag());
        }

        @Test
        void setLatesTrans() {
            model.setLatesTrans();
            ObservableList<Transactions> latestTransactions = model.getLatesTrans();
            assertNotNull(latestTransactions);
            assertFalse(latestTransactions.isEmpty());
        }

        @Test
        void getAllTrans() {
            model.setAllTrans();
            ObservableList<Transactions> allTransactions = model.getAllTrans();
            assertNotNull(allTransactions);
            assertFalse(allTransactions.isEmpty());
        }

        @Test
        void getClients() {
            model.setClient();
            ObservableList<Client> clients = model.getClients();
            assertNotNull(clients);
            assertFalse(clients.isEmpty());
        }

        @Test
        void getCheckingAccount() {
            assertNotNull(model.getCheckingAccount("valid_username"));
        }

        @Test
        void getSavingAccount() {
            assertNotNull(model.getSavingAccount("valid_username"));
        }
    }
}