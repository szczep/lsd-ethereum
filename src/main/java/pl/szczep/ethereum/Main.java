package pl.szczep.ethereum;


import java.io.IOException;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;

public class Main {

    public static void main(String[] args) throws Exception {

        Web3j web3j = connectToRemoteEthereumNode();

        Credentials credentials = loanWallet();

//        Greeting contract = deployContractToTheNetwork(web3j, credentials, "Hello blockchain world!");


        System.out.println(getGreetingsFromContract(web3j, credentials));

        TransactionReceipt transactionReceipt = setGreetingsForContract(web3j, credentials, "Hello again");

        System.out.println(getGreetingsFromContract(web3j, credentials));

    }

    private static String getGreetingsFromContract(Web3j web3j, Credentials credentials) throws Exception {
        return getGreeting(web3j, credentials).greet().send();
    }

    private static TransactionReceipt setGreetingsForContract(Web3j web3j, Credentials credentials, String  message) throws Exception {
        return getGreeting(web3j, credentials).setGreeting(message).send();
    }

    private static Greeting getGreeting(Web3j web3j, Credentials credentials) {
        return new Greeting("0x675DA84d6a04E5A45897058218CE1885997c2bB9",
                web3j, credentials, new DefaultGasProvider());
    }

    private static Greeting deployContractToTheNetwork(Web3j web3j, Credentials credentials, String message) throws Exception {
        Greeting contract = Greeting.deploy(web3j,
                credentials,
                new DefaultGasProvider(),
                message).send();

        String contractAddress = contract.getContractAddress();
        System.out.println(contractAddress);
        return contract;
    }

    private static Credentials loanWallet() throws IOException, CipherException {
        return WalletUtils.loadCredentials(
                "lsd",
                "C:/git/lsd-ethereum/UTC--2019-01-24T18-56-51.941000000Z--d7da9a113eb6f05f1a3343505012c111c0385730.json");
    }

    private static Web3j connectToRemoteEthereumNode() {
        final HttpService httpService = new HttpService("https://rinkeby.infura.io/13e72ee0fbea4fc8af564d61efa5bf79s");

        return Web3j.build(httpService);
    }
}
