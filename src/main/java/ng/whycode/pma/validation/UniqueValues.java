package ng.whycode.pma.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD})//Indicates the contexts in which an annotation type is applicable
@Retention(RetentionPolicy.RUNTIME)//Indicates how long annotations with the annotated type are to be retained.
@Constraint(validatedBy=UniqueValidator.class)
public @interface UniqueValues {
	String message() default "Unique constraint violated";
	
	Class <?>[] groups() default{};
	Class <? extends Payload>[] payload()  default{};
}
