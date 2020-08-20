<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="patient">

    <h2>Owner Information</h2>


    <table class="table table-striped">
        <tr>
            <th>Name</th>
            <td><b><c:out value="${patient.name}"/></b></td>
        </tr>
        <tr>
            <th>Address</th>
            <td><c:out value="${patient.age}"/></td>
        </tr>
        <tr>
            <th>City</th>
            <td><c:out value="${patient.weight}"/></td>
        </tr>
        <tr>
            <th>Telephone</th>
            <td><c:out value="${patient.height}"/></td>
        </tr>
    </table>

</petclinic:layout>
