package com.ap.datamodel;

public class ProductData {
	
private String productName;
private String quantity;
private String size;
private String color;

public String getProductName(){
	return productName;

}
public void setProductName(String productName) {
	this.productName = productName;
}

public String getQuantity() {
	return quantity;
}
public void setQuantity(String quantity) {
	this.quantity = quantity;
}

public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}
public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

@Override
/**hashCode belongs to object class, and equals too. Is recommended to overwrite them if you gonna use it. 
hashCode is used to generate key values for hash data structures, like a hash table. It must return different
values for each object with different attribute values.
equals is used to know if two objects have the same attribute values. If you use '==', it just compare object references.
 * 
 */
public int hashCode(){
	final int prime = 31;
	int result = 1;
	/**
	 * When it invokes on the same object more than once during execution
	 * it should consistently return the same value without foreign value
	 * The general contract of hashCode is: 
•Whenever it is invoked on the same object more than once during an execution of a Java application, the hashCode method
must consistently return the same integer, provided no information used in equals comparisons on the object is modified.This 
integer need not remain consistent from one execution of an application to another execution of the same application. 
•If two objects are equal according to the equals(Object)method, then calling the hashCode method on each ofthe two objects 
must produce the same integer result. 
	 */
	/* 
	basically if the name is null (no object of string class is assigned to name) it counts result as :
	prime*result (because result is 1 it can even be just prime)
	is the name is not null it counts hash (result) as sum of prime*result + name.hashCode () (hashCode of name added with prime)
	here the ternary operator is used instead of if statement (https://en.m.wikipedia.org/wiki/%3F:)
	 */
	
/*	result = prime * result + ((color==null)? 0 : color.hashCode());
	result = prime * result + ((productName==null)? 0 : productName.hashCode());
	result = prime * result + ((quantity==null)? 0 : quantity.hashCode());
	result = prime * result + ((size==null)? 0 : size.hashCode());
	*/
	return result;
	

/*where the function returns true, when object to be compared is the same ( it is the same instance of class)
when the object to compare is null (actually nothing) or is not of the same class, it returns false
( there is the case, when the object is of same class but not the exactly same instance, which is not considered )
*/
}

@Override
public boolean equals(Object obj){
	 // checking if both the object references are  
    // referring to the same object. 
   
	if (this == obj)
		return true;
	  // it checks if the argument is of the  
    // type ProductData by comparing the classes  
    // of the passed argument and this object. 
    // if(!(obj instanceof ProductData)) return false; ---> avoid. 
 
	if (this == null)
		return false;
	if(getClass()!=obj.getClass())
		return false;
		
	ProductData other = (ProductData) obj;
	if(color == null){
		if(other.color !=null)
			return false;
	}
	else if (!color.equals(other.color))
		return false;
	
		if(productName==null){
		if(other.productName !=null)
			return false;
			} else if (!productName.equals(other.productName))
				return false;
	
	
	if(quantity==null){
		if(other.quantity!=null)
			return false;
		} else if (!quantity.equals(other.quantity))
			return false;
	
	if(size==null){
		if(other.size!=null)
			return false;
		} else if (!size.equals(other.size))
			return false;
			
			return true;
	
}


@Override//To Generate right click -> Source ->Generate To String and include all with methods and inherited Methods
public String toString() {
	
    return "ProductData [productname=" + productName + ", quantity=" + quantity + ", size=" + size + ", color="
            + color + ", getproductname()=" + getProductName() + ", getQuantity()=" + getQuantity() + ", getSize()="
            + getSize() + ", getColor()=" + getColor() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
            + ", toString()=" + super.toString() + "]";
	
}


}
