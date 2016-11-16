package ru.servachek.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPromoCodeTemplate is a Querydsl query type for PromoCodeTemplate
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPromoCodeTemplate extends EntityPathBase<PromoCodeTemplate> {

    private static final long serialVersionUID = -1358744818L;

    public static final QPromoCodeTemplate promoCodeTemplate = new QPromoCodeTemplate("promoCodeTemplate");

    public final DateTimePath<java.util.Date> created_at = createDateTime("created_at", java.util.Date.class);

    public final StringPath id = createString("id");

    public final SimplePath<LandingPage> landing_page = createSimple("landing_page", LandingPage.class);

    public final StringPath mask = createString("mask");

    public final NumberPath<Integer> payer_type = createNumber("payer_type", Integer.class);

    public final ArrayPath<PromoSale[], PromoSale> promos = createArray("promos", PromoSale[].class);

    public final StringPath title = createString("title");

    public final DateTimePath<java.util.Date> updated_at = createDateTime("updated_at", java.util.Date.class);

    public final ArrayPath<UserGroup[], UserGroup> user_groups = createArray("user_groups", UserGroup[].class);

    public final ArrayPath<User[], User> users = createArray("users", User[].class);

    public QPromoCodeTemplate(String variable) {
        super(PromoCodeTemplate.class, forVariable(variable));
    }

    public QPromoCodeTemplate(Path<? extends PromoCodeTemplate> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPromoCodeTemplate(PathMetadata metadata) {
        super(PromoCodeTemplate.class, metadata);
    }

}

