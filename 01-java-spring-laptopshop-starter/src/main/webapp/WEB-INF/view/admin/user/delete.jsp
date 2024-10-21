<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Delete User ${dataUser.id}</title>
                <!-- Latest compiled and minified CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

                <!-- Latest compiled JavaScript -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>


                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                <!-- <link rel="stylesheet" href="css/demo.css"> -->
            </head>

            <body>
                <div class="container mt-5">
                    <div class="row">
                        <div class="col-12  mx-auto">
                            <div class="d-flex justify-content-between">
                                <h2>Delete Users id ${dataUser.id}</h2>

                            </div>
                            <hr>
                            <div>
                                <div class="alert alert-danger" role="alert">
                                    Do you want to Delete this User ahve ID = ${dataUser.id}
                                </div>
                                <form:form method="POST" action="/admin/user/delete/${dataUser.id}"
                                    modelAttribute="newUser">
                                    <div class="mb-3" hidden>
                                        <label for="exampleInputEmail1" class="form-label">Email</label>
                                        <form:input value="${dataUser.id}" type="text" class="form-control" path="id" />
                                    </div>

                                    <button type="submit" class="btn btn-danger">Confirm</button>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </body>

            </html>