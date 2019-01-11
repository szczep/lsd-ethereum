#### Connecting to the Ethereum network

Sing up to the [infure](https://infura.io/) and get your private token to access Ethereum test network: 

```https://rinkeby.infura.io/v3/<yor unique access token>```

Download `web3j` command line application form the [github releases](https://github.com/web3j/web3j/releases).

Create your wallet with the command:

```web3j wallet create```
    
You can verify your wallet by checking your account at the [etherscan.io](https://rinkeby.etherscan.io/address/0xb860d954b1f1988dd557a195ec2e90fa100f6cbe) 
and searching for your address taken from wallet:  

```"address": "b860d954b1f1988dd557a195ec2e90fa100f6cbe",```

You can request some free ether for the rinkeby test network [here](https://www.rinkeby.io/#faucet)
    	
Download solidity compiler for windows from [here](https://github.com/ethereum/solidity/releases).

Compile smartContract:

```web3j solidity generate -b <smart_contract>.bin -a <smart_contract>.abi -o src/main/java -p <package_name>```