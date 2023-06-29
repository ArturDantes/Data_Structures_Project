public class Main {
    public static void main(String[] args) {
        // Create a hash table
        HashTable<String, Integer> hashTable = new HashTable<>();

        // Put some key-value pairs into the hash table
        hashTable.put("apple", 10);
        hashTable.put("banana", 20);
        hashTable.put("cherry", 30);
        hashTable.put("date", 40);

        // Get values from the hash table
        System.out.println("Updated value for 'banana': " + hashTable.get("banana")); // Output: Updated value for 'banana':
        System.out.println("Value for 'apple': " + hashTable.get("apple"));     // Output: Value for 'apple': 10
        System.out.println("Value for 'cherry': " + hashTable.get("cherry"));   // Output: Value for 'cherry': 30

        // Update a value in the hash table
        hashTable.put("banana", 999);
        System.out.println("Updated value for 'banana': " + hashTable.get("banana")); // Output: Updated value for 'banana': 25

        // Remove a key-value pair from the hash table
        hashTable.remove("date");
        System.out.println("Value for 'date' after removal: " + hashTable.get("date")); // Output: Value for 'date' after removal: null

        // Check the size of the hash table
        System.out.println("Size of the hash table: " + hashTable.getSize()); // Output: Size of the hash table: 3
        hashTable.put("Artur", 18);
        System.out.println("Value for 'Artur': " + hashTable.get("Artur")); 
        System.out.println("Size of the hash table: " + hashTable.getSize());
    }
}
