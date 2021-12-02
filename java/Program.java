public class Program
{
    public static void main(String[] args)
    {
        UserController u = new UserController();
        User user = new User("123", "123$#sdfj(!#)aHHDS");
        User user1 = new User("123", "123$#sdfj(!#)aHHDS");



        System.out.println( u.add(user));
        System.out.println( u.add(user1));
    }
}
