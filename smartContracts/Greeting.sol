pragma solidity ^0.5.2;

contract Greeting {
    address creator;
    string message;

    constructor(string memory _message) public {
        message = _message;
        creator = msg.sender;
    }

    function greet() public view returns (string memory)  {
        return message;
    }

    function setGreeting(string memory _message) public {
        message = _message;
    }
}