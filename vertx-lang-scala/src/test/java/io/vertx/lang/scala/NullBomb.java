package io.vertx.lang.scala;

/*-
 * #%L
 * Vert.x Scala Language Support
 * %%
 * Copyright (C) 2016 vert.x
 * %%
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 * #L%
 */

/**
 * A class that returns
 */
public class NullBomb {
    public Byte nullByte() {
        return null;
    }

    public Byte byte23() {
        return 23;
    }
}