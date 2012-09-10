/**
 * if we just assign the 'parameter' stereotype to the annotation stereotypes like 'template',
 * we have no change to mark the workflow parameter 'template' as required without
 * providing a value!
 * 
 * -> we need to mark the data fields as workflow parameter and mark them with required and optional
 * -> we need to mark annotation stereotypes like 'template' as workflow parameter
 * 
 * -> multi valued is more related to the data field as it stores the values
 * 
 * the parameter stereotype should be generated with annotation @documented
 * -> either extending the java5annotation stereotype
 * -> or providing a separate one
 * 
 * all workflow parameters with default values directly set
 * on the fields and where is no change to change this default value
 * the inheritance hierarchy downwards, do not need a stereotype here
 * -> the stereotype should be automatically created + added by a 
 * model transformation
 */
package org.genesez.workflow.profile;

