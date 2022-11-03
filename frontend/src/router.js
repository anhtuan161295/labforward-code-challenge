import React from "react";
import { Route, Switch, Redirect, Routes } from "react-router-dom";
import MainPage from "./pages/main-page";

const Router = () => (
    <Routes>
        <Route path="/" element={<MainPage />} />
    </Routes>
);

export default Router;