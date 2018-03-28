package annotations.repeatable;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionTestContainer.class)
public @interface ExceptionTest {

    Class<? extends Throwable> value();

    /**
     * 当在使用@Repeatable注解来使得某一注解可以重复声明
     * 但是在使用isAnnotationPresent来判断注解类型时，需要同时判断 ExceptionTest 和 ExceptionTestContainer
     * 因为ExceptionTest实际被当做ExceptionTestContainer
     *
     * @ExceptionTest 和 @ExceptionTestContainer 不能同时使用
     */
}
