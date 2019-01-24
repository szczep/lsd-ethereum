package pl.szczep.ethereum;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.1.1.
 */
public class Greeting extends Contract {
    private static final String BINARY = "60c0604052601160808190527f4c53442049532054484520424553543a2000000000000000000000000000000060a090815261003e91600191906100e6565b5034801561004b57600080fd5b506040516105cb3803806105cb8339810180604052602081101561006e57600080fd5b81019080805164010000000081111561008657600080fd5b8201602081018481111561009957600080fd5b81516401000000008111828201871017156100b357600080fd5b505080519093506100cd92506002915060208401906100e6565b505060008054600160a060020a03191633179055610181565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061012757805160ff1916838001178555610154565b82800160010185558215610154579182015b82811115610154578251825591602001919060010190610139565b50610160929150610164565b5090565b61017e91905b80821115610160576000815560010161016a565b90565b61043b806101906000396000f3fe608060405234801561001057600080fd5b5060043610610052577c01000000000000000000000000000000000000000000000000000000006000350463a41368628114610057578063cfae3217146100ff575b600080fd5b6100fd6004803603602081101561006d57600080fd5b81019060208101813564010000000081111561008857600080fd5b82018360208201111561009a57600080fd5b803590602001918460018302840111640100000000831117156100bc57600080fd5b91908080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525092955061017c945050505050565b005b610107610193565b6040805160208082528351818301528351919283929083019185019080838360005b83811015610141578181015183820152602001610129565b50505050905090810190601f16801561016e5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b805161018f906002906020840190610377565b5050565b60018054604080516020600284861615610100026000190190941693909304601f81018490048402820184019092528181526060936102b693919290918301828280156102215780601f106101f657610100808354040283529160200191610221565b820191906000526020600020905b81548152906001019060200180831161020457829003601f168201915b505060028054604080516020601f60001961010060018716150201909416859004938401819004810282018101909252828152955091935091508301828280156102ac5780601f10610281576101008083540402835291602001916102ac565b820191906000526020600020905b81548152906001019060200180831161028f57829003601f168201915b50505050506102bc565b90505b90565b606082826040516020018083805190602001908083835b602083106102f25780518252601f1990920191602091820191016102d3565b51815160209384036101000a600019018019909216911617905285519190930192850191508083835b6020831061033a5780518252601f19909201916020918201910161031b565b6001836020036101000a03801982511681845116808217855250505050505090500192505050604051602081830303815290604052905092915050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106103b857805160ff19168380011785556103e5565b828001600101855582156103e5579182015b828111156103e55782518255916020019190600101906103ca565b506103f19291506103f5565b5090565b6102b991905b808211156103f157600081556001016103fb56fea165627a7a7230582094c998740aaf013cc22b27a9c43b276d54c08abe72f5912039a015dc19e72e0c0029";

    public static final String FUNC_SETGREETING = "setGreeting";

    public static final String FUNC_GREET = "greet";

    @Deprecated
    protected Greeting(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Greeting(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Greeting(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Greeting(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> setGreeting(String _message) {
        final Function function = new Function(
                FUNC_SETGREETING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_message)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> greet() {
        final Function function = new Function(FUNC_GREET, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static Greeting load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Greeting(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Greeting load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Greeting(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Greeting load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Greeting(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Greeting load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Greeting(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Greeting> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _message) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_message)));
        return deployRemoteCall(Greeting.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Greeting> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _message) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_message)));
        return deployRemoteCall(Greeting.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Greeting> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _message) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_message)));
        return deployRemoteCall(Greeting.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Greeting> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _message) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_message)));
        return deployRemoteCall(Greeting.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
