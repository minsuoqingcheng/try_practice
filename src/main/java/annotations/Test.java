package annotations;

import java.lang.annotation.*;

/**
 * 只能使用在静态方法上
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@interface Test {
}
