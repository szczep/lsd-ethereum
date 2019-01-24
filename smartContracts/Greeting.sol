pragma solidity ^0.5.2;

contract Greeting {
    address creator;
    string basicMessage = "LSD IS THE BEST: ";
    string message;

    constructor(string memory _message) public {
        message = _message;
        creator = msg.sender;
    }

    function greet() public view returns (string memory)  {
        return append(basicMessage, message);
    }

    function setGreeting(string memory _message) public {
        message = _message;
    }

    function append(string memory a, string memory b) internal pure returns (string memory) {

        return string(abi.encodePacked(a, b));

    }
}
