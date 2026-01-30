# fakeRSA

A simplified implementation of RSA encryption and decryption algorithm in Java for educational purposes.

## What It Does

This project implements a basic version of the RSA (Rivest-Shamir-Adleman) cryptographic algorithm. It demonstrates the fundamental concepts of public-key cryptography by:

- Generating RSA key pairs (public and private keys)
- Encrypting numeric messages using the public key
- Decrypting cipher text using the private key
- Computing modular arithmetic operations essential to RSA

## How It Works

The implementation follows the core RSA algorithm workflow:

### Key Generation

1. **Prime Selection**: Two prime numbers `p` and `q` are selected (currently hardcoded as 26893 and 26633 for demonstration)
2. **Modulus Calculation**: Computes `n = p * q` (the modulus for both encryption and decryption)
3. **Totient Function**: Calculates Euler's totient function `φ(n) = (p-1) * (q-1)`
4. **Public Exponent**: Uses `e = 7` as the public exponent (typically coprime to φ(n))
5. **Private Exponent**: Computes `d` as the modular multiplicative inverse of `e` modulo φ(n) using the Extended Euclidean Algorithm

### Encryption

The encryption process transforms a plaintext message `m` into ciphertext `c`:
```
c = m^e mod n
```

### Decryption

The decryption process recovers the original message from ciphertext:
```
m = c^d mod n
```

### Mathematical Components

- **Modular Exponentiation**: Implements efficient modular exponentiation using the binary method to handle large numbers
- **Extended Euclidean Algorithm**: Calculates the modular multiplicative inverse required for private key generation
- **Prime Number Generation**: Contains utilities for generating and testing prime numbers (randomPrime and primeFinder methods)

## Project Structure

- **Main.java**: Entry point demonstrating encryption and decryption workflow
- **encrypter.java**: Handles RSA key generation and encryption operations
- **decrypter.java**: Extends encrypter class to perform decryption operations
- **nmaker.java**: Alternative implementation with different parameter generation approach

## Tech Stack

- **Language**: Java
- **Core Libraries**: 
  - `java.math.BigInteger` - For handling large integer arithmetic
  - `java.util.Random` - For random number generation
- **Algorithms**:
  - Modular exponentiation (binary method)
  - Extended Euclidean Algorithm
  - Prime number generation and testing
- **Paradigm**: Object-oriented programming with class inheritance

## Usage

The main class demonstrates basic usage:

```java
encrypter lock = new encrypter();  // Generate keys
long m = 1234;                     // Original message
long encrypted = lock.encrypt(m);  // Encrypt
decrypter key = new decrypter(encrypted);  // Decrypt
```

## Educational Notes

This is a simplified implementation for learning purposes and should **not** be used in production environments. Real-world RSA implementations require:

- Larger prime numbers (typically 1024-4096 bits)
- Secure random number generation
- Proper padding schemes (OAEP, PSS)
- Protection against timing attacks
- Industry-standard cryptographic libraries

## Security Disclaimer

This implementation uses small prime numbers and lacks many security features required for real cryptographic applications. It is intended solely for educational purposes to understand the mathematical foundations of RSA encryption.
