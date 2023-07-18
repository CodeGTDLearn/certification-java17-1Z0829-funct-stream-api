package method_refer;

public class OuterReferMethods {

  static class staticClass {
    public void InstanceMethod() {

      System.out.println("staticClass - myInstanceMethod");
    }

    public static void staticMethod() {

      System.out.println("staticClass - myStaticMethod");
    }
  }

  public class innerClass {
    public void InstanceMethod() {

      System.out.println("innerClass - myInstanceMethod");
    }

    public static void staticMethod() {

      System.out.println("innerClass - myStaticMethod");
    }
  }

  public static void main(String[] args) {

    new OuterReferMethods().innerClassTests();
    new OuterReferMethods().staticClassTests();
  }

  private void staticClassTests(){

    new OuterReferMethods.staticClass().InstanceMethod();
    final Runnable callInstance = new staticClass()::InstanceMethod;
    final Runnable callInstance1 = new OuterReferMethods.staticClass()::InstanceMethod;
    callInstance.run();
    callInstance1.run();

    OuterReferMethods.staticClass ti   =   new OuterReferMethods.staticClass();
    OuterReferMethods.staticClass.staticMethod();
    final Runnable callStatic1 = staticClass::staticMethod;
    final Runnable callStatic2 = OuterReferMethods.staticClass::staticMethod;
    callStatic1.run();
    callStatic2.run();
  }

  private void innerClassTests() {
    var classRefer = new OuterReferMethods();
    var innerClass_All_Instancias = classRefer.new innerClass();

    innerClass_All_Instancias.InstanceMethod();
    final Runnable caller = innerClass_All_Instancias::InstanceMethod;
    final Runnable caller1 = new OuterReferMethods().new innerClass()::InstanceMethod;
    caller.run();
    caller1.run();

    OuterReferMethods.innerClass.staticMethod();
    final Runnable stCaller1 = OuterReferMethods.innerClass::staticMethod;
    stCaller1.run();
  }

}