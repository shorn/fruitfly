package fruitfly.example;

import fruitfly.test.FruitflyTestCase;

import static org.assertj.core.api.Assertions.assertThat;

public class RecordUsageExampleTest extends FruitflyTestCase {

  public void testShowUsage() {
    var max = MovieCharacter.builder().
      name("Miracle Max").
      addressLine1("King's forest").
      postcode("2T4000").
      country("Florin").
      status("supporting-character").
      build();

    assertThat(max.name()).isEqualTo("Miracle Max");

    var valerie = max.but().name("Valerie").build();

    assertThat(valerie.name()).isEqualTo("Valerie");
  }
}
