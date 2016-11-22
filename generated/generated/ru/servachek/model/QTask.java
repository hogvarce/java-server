package ru.servachek.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTask is a Querydsl query type for Task
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTask extends EntityPathBase<Task> {

    private static final long serialVersionUID = 953803693L;

    public static final QTask task = new QTask("task");

    public final DateTimePath<java.util.Date> created_at = createDateTime("created_at", java.util.Date.class);

    public final NumberPath<Integer> current_operation = createNumber("current_operation", Integer.class);

    public final StringPath error = createString("error");

    public final DateTimePath<java.util.Date> finished_at = createDateTime("finished_at", java.util.Date.class);

    public final StringPath id = createString("id");

    public final ArrayPath<String[], String> options = createArray("options", String[].class);

    public final DateTimePath<java.util.Date> started_at = createDateTime("started_at", java.util.Date.class);

    public final StringPath status = createString("status");

    public final StringPath title = createString("title");

    public final NumberPath<Integer> total_operation = createNumber("total_operation", Integer.class);

    public final StringPath type = createString("type");

    public final DateTimePath<java.util.Date> updated_at = createDateTime("updated_at", java.util.Date.class);

    public QTask(String variable) {
        super(Task.class, forVariable(variable));
    }

    public QTask(Path<? extends Task> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTask(PathMetadata metadata) {
        super(Task.class, metadata);
    }

}

