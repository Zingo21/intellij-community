import java.util.List;
import java.util.Map;

abstract class NoImports implements List<NoImports.A> {
  Map.Entry entry;
  <caret>NoImports.A a;

  class A {}
}
class RecordQualifier {
  private static record CalcResult(RecordQualifier.CalcResult.Type type) {

    enum Type {
      OK, ERROR
    }
  }
}