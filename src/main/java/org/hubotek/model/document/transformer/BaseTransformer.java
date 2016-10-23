package org.hubotek.model.document.transformer;

import java.util.function.Function;

import org.nanotek.Base;

@FunctionalInterface
public interface BaseTransformer<T extends Base<?> , R extends Base<?>> extends Function<T,R>{

}
