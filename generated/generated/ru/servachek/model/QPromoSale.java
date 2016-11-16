package ru.servachek.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPromoSale is a Querydsl query type for PromoSale
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPromoSale extends EntityPathBase<PromoSale> {

    private static final long serialVersionUID = -1257715506L;

    public static final QPromoSale promoSale = new QPromoSale("promoSale");

    public final DateTimePath<java.util.Date> created_at = createDateTime("created_at", java.util.Date.class);

    public final BooleanPath current = createBoolean("current");

    public final BooleanPath disabled = createBoolean("disabled");

    public final ListPath<Object, SimplePath<Object>> discounts = this.<Object, SimplePath<Object>>createList("discounts", Object.class, SimplePath.class, PathInits.DIRECT2);

    public final DateTimePath<java.util.Date> end_time = createDateTime("end_time", java.util.Date.class);

    public final DateTimePath<java.util.Date> finished_at = createDateTime("finished_at", java.util.Date.class);

    public final StringPath guid = createString("guid");

    public final StringPath id = createString("id");

    public final StringPath label = createString("label");

    public final NumberPath<Integer> max_price = createNumber("max_price", Integer.class);

    public final NumberPath<Integer> max_quantity_per_sku = createNumber("max_quantity_per_sku", Integer.class);

    public final StringPath mechanics = createString("mechanics");

    public final NumberPath<Integer> min_price = createNumber("min_price", Integer.class);

    public final NumberPath<Integer> priority = createNumber("priority", Integer.class);

    public final ListPath<Object, SimplePath<Object>> product_sets = this.<Object, SimplePath<Object>>createList("product_sets", Object.class, SimplePath.class, PathInits.DIRECT2);

    public final ListPath<Object, SimplePath<Object>> regions = this.<Object, SimplePath<Object>>createList("regions", Object.class, SimplePath.class, PathInits.DIRECT2);

    public final StringPath sap_code = createString("sap_code");

    public final NumberPath<Integer> semFilterId = createNumber("semFilterId", Integer.class);

    public final DateTimePath<java.util.Date> start_time = createDateTime("start_time", java.util.Date.class);

    public final DateTimePath<java.util.Date> started_at = createDateTime("started_at", java.util.Date.class);

    public final StringPath title = createString("title");

    public final DateTimePath<java.util.Date> updated_at = createDateTime("updated_at", java.util.Date.class);

    public QPromoSale(String variable) {
        super(PromoSale.class, forVariable(variable));
    }

    public QPromoSale(Path<? extends PromoSale> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPromoSale(PathMetadata metadata) {
        super(PromoSale.class, metadata);
    }

}

