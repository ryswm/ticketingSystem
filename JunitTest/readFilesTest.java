public class readFilesTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void shouldReadFiles(){

        File tempTransactions = folder.newFile("transactionFile.txt");
        File tempAccount = folder.newFile("AccountFile.txt");
        File tempEvent = folder.newFile("eventFile.txt");

    }
}
