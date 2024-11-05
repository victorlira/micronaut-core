package io.micronaut.test.lombok;

import io.micronaut.core.beans.BeanIntrospection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class LombokIntrospectedBuilderTest {

    @Test
    void testLombokBuilder() {
        BeanIntrospection.Builder<RobotEntity> builder = BeanIntrospection.getIntrospection(RobotEntity.class)
            .builder();

        RobotEntity robotEntity = builder.with("name", "foo")
            .build();

        Assertions.assertEquals("foo", robotEntity.getName());
    }

    @Test
    void testLombokBuilderWithInnerClasses() {
        BeanIntrospection.Builder<SimpleEntity> builder = BeanIntrospection.getIntrospection(SimpleEntity.class)
            .builder();

        String id = UUID.randomUUID().toString();
        SimpleEntity simpleEntity = builder.with("id", id)
            .build();

        Assertions.assertEquals(id, simpleEntity.getId());

        BeanIntrospection<SimpleEntity.CompartmentCreationTimeIndexPrefix> introspection =
            BeanIntrospection.getIntrospection(SimpleEntity.CompartmentCreationTimeIndexPrefix.class);
        Assertions.assertNotNull(introspection);
    }
}
