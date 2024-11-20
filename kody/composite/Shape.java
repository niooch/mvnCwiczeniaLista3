/**
 * Copyright 2011 Joao Miguel Pereira
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package eu.jpereira.trainings.designpatterns.structural.composite.model;
import java.util.ArrayList;
import java.util.List;


/**
 * @author jpereira
 *
 */
public abstract class Shape {
	// The shape coordinates
	private int x;
	private int y;

	/**
	 * If this object is a CompositeShape, return it. Null otherwise.
	 *
	 * @return an compositeShape instance if this is an composite, null
	 *         otherwise
	 */
	public CompositeShape asComposite() {
        if (this instanceof CompositeShape) {
            return (CompositeShape) this;
        }
		return null;
	}

	/**
	 * Move a shape in a 2D scale
	 *
	 * @param xIncrement
	 *            The increment in X axis
	 * @param yIncremet
	 *            The increment in the Y axis
	 */
	public void move(int xIncrement, int yIncrement) {
		this.x += xIncrement;
		this.y += yIncrement;
        CompositeShape compositeShape = asComposite();
        if (compositeShape != null) {
            for (Shape shape : compositeShape.getShapes()) {
                shape.move(xIncrement, yIncrement);
            }
        }
	}

	/**
	 * @return the x coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x coordinate to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y coordinate to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Each instance of a Shape must know it's type
	 * @return
	 */
	public abstract ShapeType getType();

    public void addShape(Shape shape) throws ShapeDoesNotSupportChildren {
        throw new ShapeDoesNotSupportChildren();
    }

    public boolean removeShape(Shape shape) throws ShapeDoesNotSupportChildren {
        throw new ShapeDoesNotSupportChildren();
    }

    public int getShapeCount(){
        return 0;
    }

    public List<Shape> getShapesByType(ShapeType shapeType) {
        List<Shape> shapes = new ArrayList<>();
        if (this.getType() == shapeType) {
            shapes.add(this);
        }
        return shapes;
    }

    public List<Shape> getLeafShapes() {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(this);
        return shapes;
    }

}
