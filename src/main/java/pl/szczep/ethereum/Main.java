package pl.szczep.ethereum;


import java.io.IOException;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

public class Main {

    public static void main(String[] args) throws Exception {



        Web3j web3j = connectToRemoteEthereumNode();

        Credentials credentials = loanWallet();

        Greeting contract = deployContractToTheNetwork(web3j, credentials);

        String contractAddress = contract.getContractAddress();

        System.out.println(contractAddress);

    }

    private static Greeting deployContractToTheNetwork(Web3j web3j, Credentials credentials) throws Exception {

        return Greeting.deploy(web3j, credentials, new DefaultGasProvider(), "Hello blockchain world!").send();
    }

    private static Credentials loanWallet() throws IOException, CipherException {
        return WalletUtils.loadCredentials(
            "<password>",
            "<wallet>");
    }

    private static Web3j connectToRemoteEthereumNode() {
        final HttpService httpService = new HttpService("https://rinkeby.infura.io/<token>");

        return Web3j.build(httpService);
    }
}
