package com.cohort.util;

class HashDigestTests {
  @org.junit.jupiter.api.Test
  /**
   * This tests this class.
   */
  void basicTest() throws Throwable {
    System.out.println("*** HashDigest.basicTest");
    String tName = HashDigestTests.class.getResource("LICENSE.txt").getPath();
    System.out.println("*** Checksum test file: " + tName);
    Test.ensureEqual(HashDigest.doIt(new String[] { "type:MD5" }),
        "Neither password or filename was specified.\n" + HashDigest.usage, "");
    Test.ensureEqual(HashDigest.doIt(new String[] { "password:myPassword", "type:MD-5" }),
        "Invalid algorithm.\n" + HashDigest.usage, "");
    Test.ensureEqual(HashDigest.doIt(new String[] { "password:myPassword", "type:MD5" }),
        "deb1536f480475f7d593219aa1afd74c", "");
    Test.ensureEqual(HashDigest.doIt(new String[] { "password:myPassword", "type:SHA-1" }),
        "5413ee24723bba2c5a6ba2d0196c78b3ee4628d1", "");
    Test.ensureEqual(HashDigest.doIt(new String[] { "password:myPassword", "type:SHA-256" }),
        "76549b827ec46e705fd03831813fa52172338f0dfcbd711ed44b81a96dac51c6", "");
    Test.ensureEqual(HashDigest.doIt(new String[] { "filename:" + tName, "type:MD5" }),
        "327fbb2aa6c6297d4fdd5fdf4b14e289", "");
    Test.ensureEqual(HashDigest.doIt(new String[] { "filename:" + tName, "type:SHA-256" }),
        "e376c88953b2d56b00783fed071f1875e8ed94230f4e14eee5bce8bd608de5e6", "");
    Test.ensureEqual(HashDigest.doIt(new String[] { "filename:" + tName, "type:SHA-256", "-file" }),
        "Created " + tName + ".sha256", "");
    Test.ensureEqual(File2.readFromFileUtf8(tName + ".sha256")[1],
        "e376c88953b2d56b00783fed071f1875e8ed94230f4e14eee5bce8bd608de5e6  LICENSE.txt\n", "");
    File2.delete(tName + ".sha256");
  }
}
