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
//
//        Greeting contract = deployContractToTheNetwork(web3j, credentials);
//
//        String contractAddress = contract.getContractAddress();
//
//        System.out.println(contractAddress);

        Greeting contract = new Greeting("0xB392FAc952E84b92f76CD2b2E4A07906c05d7105",
                web3j, credentials, new DefaultGasProvider());

        TransactionReceipt transactionReceipt = contract.setGreeting("Hello again").send();

        String newValue = contract.greet().send();
        System.out.println(newValue);

    }

    private static Greeting deployContractToTheNetwork(Web3j web3j, Credentials credentials) throws Exception {

        return Greeting.deploy(web3j, credentials, new DefaultGasProvider(), "Hello blockchain world!").send();
    }

    private static Credentials loanWallet() throws IOException, CipherException {
        return WalletUtils.loadCredentials(
            "password",
            "/home/szczepan/projects/UTC--2019-01-08T07-47-38.955000000Z--b860d954b1f1988dd557a195ec2e90fa100f6cbe.json");
    }

    private static Web3j connectToRemoteEthereumNode() {
        final HttpService httpService = new HttpService("https://rinkeby.infura.io/13e72ee0fbea4fc8af564d61efa5bf79s");

        return Web3j.build(httpService);
    }
}
